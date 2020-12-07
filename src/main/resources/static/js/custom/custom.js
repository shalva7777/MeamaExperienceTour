function saveCustomer() {
    var nameSurname = $("#nameSurname").val();
    var comment = $("#comment").val();
    // var phone = $("#phone").val();
    // var email = $("#email").val();
    // var withGuest = document.getElementById("checkbox").checked;
    // var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;


    if (!nameSurname) {
        $('#nameSurname').addClass('error');
        if (!comment) {
            $('#comment').addClass('error');
            return;
        } else {
            $('#comment').removeClass('error');
        }
        return;
    } else {
        $('#nameSurname').removeClass('error');

    }
    if (!comment) {
        $('#comment').addClass('error');
        return;
    } else {
        $('#comment').removeClass('error');
    }

    var formData = {
        id: null,
        nameSurname: nameSurname,
        company: null,
        phone: null,
        email: null,
        withGuest: false,
        creationDate: null,
        comment: comment
    };
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/MeamaExperienceTour/save-customer",
        data: JSON.stringify(formData),
        // dataType: 'json',
        success: function (result) {
            console.log(result);
            document.getElementById("formId").style.display = "none";
            document.getElementById("successId").style.display = "block";
        },
        error: function (e) {
            console.log("ERROR: ", e);
            document.getElementById("errorId").style.display = "block";
        }
    });
}
