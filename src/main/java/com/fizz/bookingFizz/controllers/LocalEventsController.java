package com.fizz.bookingFizz.controllers;

import com.fizz.bookingFizz.domain.LocalEvent;
import com.fizz.bookingFizz.business.FileUploadUtil;
import com.fizz.bookingFizz.business.services.LocalEventService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class LocalEventsController {
    private LocalEventService localEventService;

    public LocalEventsController(LocalEventService localEventService) {
        this.localEventService = localEventService;
    }

    @GetMapping("/localevents")
    public String eventsMain(Model model){
        List<LocalEvent> localEvents = localEventService.getAllLocalEvents();
        model.addAttribute("localEvents", localEvents);
        return "localevents";
    }

    @GetMapping("/localevents/add")
    public String addLocalEvent(Model model){
        return "addLocalEvent";
    }

    @PostMapping("/localevents/add")
    public String addNewLocalEvent(@RequestParam String name, @RequestParam int capacity, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime datefrom, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateto,
                                   @RequestParam MultipartFile image, @RequestParam String description) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        LocalEvent savedLocalEvent = localEventService.saveLocalEvent(new LocalEvent(name, datefrom, dateto, fileName, description, capacity));
        String uploadDir = "localEvents-photos/" + savedLocalEvent.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, image);
        return "redirect:/localevents";
    }

    @RequestMapping("/localevents/getOne")
    @ResponseBody
    public LocalEvent getOne(Long id){
        return localEventService.getLocalEventId(id);
    }

    @RequestMapping (value = "/localevents/edit", method = {RequestMethod.PUT, RequestMethod.GET})
    public String changeItem(Long id, String newName, int capacity, String newDescription, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime newDateFrom, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime newDateTo){
        localEventService.updateItem(id, newName, newDescription, newDateFrom, newDateTo, capacity);
        return "redirect:/localevents";
    }

    @PostMapping("/localevents/{id}/remove")
    public String removeItem(@PathVariable(value = "id") Long id){
        File file = new File("localEvents-photos/" + id);
        FileSystemUtils.deleteRecursively(file);
        localEventService.deleteEvent(id);
        return "redirect:/localevents";
    }
}
