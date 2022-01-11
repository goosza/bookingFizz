$('document').ready(function (){
    $('.banner .btn-primary ').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (localevent, status){
            $('#Id').val(localevent.id);
            $('#newName').val(localevent.name);
            //$('#newDateFrom').val($.format.date(localevent.datefrom, "dd-MM-yyyy HH:mm"));
            //$('#newDateTo').val($.format.date(localevent.dateto, "dd-MM-yyyy HH:mm"));
            $('#newDescription').val(localevent.description);
        });
        $('#editModal').modal('show');
    });
})