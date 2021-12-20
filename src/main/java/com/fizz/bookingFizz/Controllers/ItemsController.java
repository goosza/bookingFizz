package com.fizz.bookingFizz.Controllers;

import com.fizz.bookingFizz.Domain.Item;
import com.fizz.bookingFizz.business.FileUploadUtil;
import com.fizz.bookingFizz.business.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ItemsController {


    private ItemService itemService;
    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }
//    @PostMapping
//    public ResponseEntity<Item> saveItem(@RequestBody Item item){
//        return new ResponseEntity<Item>(itemService.saveItem(item), HttpStatus.CREATED);
//    }
    @GetMapping("/items")
    public String itemsMain(Model model){
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "items";
    }
    @GetMapping("/items/add")
    public String addItem(Model model){
        return "addItem";
    }

    @PostMapping("/items/add")
    public String addNewItem(@RequestParam MultipartFile image, @RequestParam String name,
                             @RequestParam int quantity) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        Item savedItem = itemService.saveItem(new Item(name, quantity, fileName));
        String uploadDir = "item-photos/" + savedItem.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, image);
        return "redirect:/items";
    }
    @RequestMapping("/items/getOne")
    @ResponseBody
    public Item getOne(Long id){
        return itemService.getItemId(id);
    }

    @RequestMapping (value = "/items/edit", method = {RequestMethod.PUT, RequestMethod.GET})
    public String changeItem(Long id, String newName, int newQuantity){
        itemService.updateItem(id, newName, newQuantity);
        return "redirect:/items";
    }

    @PostMapping("/items/{id}/remove")
    public String removeItem(@PathVariable(value = "id") Long id){
        File file = new File("item-photos/" + id);
        FileSystemUtils.deleteRecursively(file);
        itemService.deleteItem(id);
        return "redirect:/items";
    }
}
