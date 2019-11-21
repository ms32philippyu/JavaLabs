$(function () {
    var $toursInfo = $('#toursInfo');
    var $name = $('#name');
    var $price = $('#price');

    $.ajax({
        type: 'GET',
        url: '/api/tours/',
        success: function (tours) {
            $.each(tours, function (index, tour) {
                $toursInfo.append('<li>' +
                    '<p>' +
                        '<strong>First name: </strong>' +
                        '<span class="noedit">'+tour.name+'</span>' +
                        '<input class="edit name"/>' +
                    '</p>' +
                    '<p>' +
                        '<strong>Last name: </strong>' +
                        '<span class="noedit">'+tour.price+'$</span>' +
                        '<input class="edit price"/>' +
                    '</p>' +
                    '<button id="deleteTour" onclick="deleteTour('+tour.id+')">Delete</button>' +
                    '<button class="editTour noedit">Edit</button>' +
                    '<button class="saveEdit edit" onclick="saveTour('+tour.id+')">Save</button>' +
                    '<button class="cancelEdit edit">Cancel</button>' +
                    '</li>')
            });
        }
    });

    $('#add-tour').on('click', function () {
        var tour = {
            name: $name.val(),
            price: $price.val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/tours/',
            data: JSON.stringify(tour),
            contentType: "application/json",
            success: function () {
                console.log("created");
                window.location.reload();
            }
        })
    });

    $toursInfo.delegate('.editTour', 'click', function () {
        var $li = $(this).closest('li');
        $li.find('input.name').val($li.find('span.name').html());
        $li.find('input.price').val($li.find('span.price').html());
        $li.addClass('edit');
    });

    $toursInfo.delegate('.cancelEdit', 'click', function () {
        $(this).closest('li').removeClass('edit');
    });
});

function deleteTour(id) {
    $.ajax({
        url: '/api/tours/' + id,
        type: 'DELETE',
        success: function () {
            console.log('Deleted');
            window.location.reload();
        }
    });
}
function saveTour(id){
    var $toursInfo = $('#toursInfo');
    $toursInfo.delegate('.saveEdit', 'click', function () {
        var $li = $(this).closest('li');
        var tour = {
            name: $li.find('input.name').val(),
            price: $li.find('input.price').val()
        };

        $.ajax({
            type: 'PUT',
            url: '/api/tours/' + id,
            data: JSON.stringify(tour),
            contentType: "application/json",
            success: function () {
                $li.removeClass('edit');
                window.location.reload();
            }
        })
    });
}
