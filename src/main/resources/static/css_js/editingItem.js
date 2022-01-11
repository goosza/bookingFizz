$('document').ready(function (){
    $('.card .btn-primary').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (item, status){
            $('#Id').val(item.id);
            $('#newName').val(item.name);
            $('#newQuantity').val(item.quantity);
        });
        $('#editModal').modal('show');
    });
})