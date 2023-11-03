

//update customer
$("#btnUpdateCustomer").click(function () {

    let nicNo = $('#txtNicId').val();
    let name = $('#txtCusName').val();
    let address = $('#txtCusAddress').val();
    let email = $('#txtCusEmail').val();
    let contact = $('#txtCusContactNo').val();
    let password = $('#txtPassword').val();


    var customer = {
        customerId: nicNo,
        name: name,
        address: address,
        contactNo: contact,
        email: email,
        nicNo: password,
    }


    $.ajax({
        url: baseUrl + "Customer",
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(customer),
        success: function (rep) {
            swal({
                title: "Confirmation!",
                text: "Customer Updated Successfully",
                icon: "success",
                button: "Close",
                timer: 2000
            });

        },
        error: function (rep) {
            swal({
                title: "Error!",
                text: "Customer Not Updated Successfully",
                icon: "error",
                button: "Close",
                timer: 2000
            });
        }
    });
});

