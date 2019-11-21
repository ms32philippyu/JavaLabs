$(function () {
    var $clientsInfo = $('#clientsInfo');
    var $fname = $('#fname');
    var $lname = $('#lname');
    var $email = $('#email');
    var $clientId = $('#clientId');
    var $tourId = $('#tourId');

    $.ajax({
        type: 'GET',
        url: '/api/clients/',
        success: function (clients) {
            $.each(clients, function (index, client) {
                  $clientsInfo.append(
                      '<li>' +
                          '<p>' +
                              '<strong>First name: </strong>' +
                              '<span class="noedit">'+client.fname+'</span>' +
                              '<input class="edit fname"/>' +
                          '</p>' +
                          '<p>' +
                              '<strong>Last name: </strong>' +
                              '<span class="noedit">'+client.lname+'</span>' +
                              '<input class="edit lname"/>' +
                          '</p>' +
                          '<p>' +
                              '<strong>Email: </strong>' +
                              '<span class="noedit">'+client.email+'</span>' +
                              '<input class="edit email"/>' +
                          '</p>' +
                          '<button id="deleteClient" onclick="deleteClient('+client.id+')">Delete</button>' +
                          '<button class="editClient noedit">Edit</button>' +
                          '<button class="saveEdit edit" onclick="saveClient('+client.id+')">Save</button>' +
                          '<button class="cancelEdit edit">Cancel</button>' +
                      '</li>');
                $.each(client.tours, function (index, tour) {
                    $clientsInfo.append('<p style="font-weight: bold">Tour: '+tour.name+'</p>' +
                                        '<p>Price: '+tour.price+'$</p>')
                });
            });
        }
    });
    
    $('#add-client').on('click', function () {
        var client = {
            fname: $fname.val(),
            lname: $lname.val(),
            email: $email.val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/clients/',
            data: JSON.stringify(client),
            contentType: "application/json",
            success: function () {
                console.log("created");
                window.location.reload();
            }
        })
    });

    $('#add-tour-to-client').on('click', function () {

        var addTourRequest = {
            clientId: $clientId.val(),
            tourId: $tourId.val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/clients/addTourToClient',
            data: JSON.stringify(addTourRequest),
            contentType: "application/json",
            success: function () {
                console.log("added");
                window.location.reload();
            }
        })
    });

    $clientsInfo.delegate('.editClient', 'click', function () {
        var $li = $(this).closest('li');
        $li.find('input.fname').val($li.find('span.fname').html());
        $li.find('input.lname').val($li.find('span.lname').html());
        $li.find('input.email').val($li.find('span.email').html());
        $li.addClass('edit');
    });

    $clientsInfo.delegate('.cancelEdit', 'click', function () {
        $(this).closest('li').removeClass('edit');
    });
});

function deleteClient(id) {
    $.ajax({
        url: '/api/clients/' + id,
        type: 'DELETE',
        success: function () {
            console.log('Deleted');
            window.location.reload();
        }
    });
}
function saveClient(id){
    var $clientsInfo = $('#clientsInfo');
    $clientsInfo.delegate('.saveEdit', 'click', function () {
        var $li = $(this).closest('li');
        var client = {
            fname: $li.find('input.fname').val(),
            lname: $li.find('input.lname').val(),
            email: $li.find('input.email').val()
        };

        $.ajax({
            type: 'PUT',
            url: '/api/clients/' + id,
            data: JSON.stringify(client),
            contentType: "application/json",
            success: function () {
                $li.removeClass('edit');
                window.location.reload();
            }
        })
    });
}