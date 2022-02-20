$('document').ready(function (){
    var item_id;
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
    $('.btn-success').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (item, status){
            item_id = item.id;
            console.log(item_id);
        });
        $('#bookingModal').modal('show');
    });

    $("#chooseBtn").click(function(){
        $.ajax({
            type: 'POST',
            url: 'items/analyzing',
            data: {
                "item_id": item_id,
                "localDate": $('#inputDate').attr('value')
            },
            success: function(data) {
                $('#book').prop('disabled', false);
                $('#response').text('Response: ' + JSON.stringify(data));
            }
        });
    })
})