generateNextCarRentId();

searchCustomerById(username);
console.log(selectedCustomer);

let  customerDetails=0;
console.log(customerDetails);

function searchCustomerById(username) {
    $.ajax({
        url: baseUrl + "Customer/" + username,
        method: "GET",
        success: function (res) {
            let customer = res.data;
            console.log(customer);
            customerDetails=customer;


        }
    });
}




function generateNextCarRentId() {
    $.ajax({
        url: baseUrl+"CarRent/generateRentId",
        method: "GET",
        success: function (res) {
            $('#txtCarRentId').val(res.data);
        }
    });
}

$('#needDriver').click(function () {
    if ($(this).is(":checked")) {
        searchRandomDriverForRent();
    } else {
        clearRentalDriverFields();
    }
})










function searchRandomDriverForRent() {
    $.ajax({
        url: baseUrl + "Driver/getRandomDriver",
        method: "GET",
        success: function (res) {
            for (let driver of res.data) {
                selectedDriverForRent=driver;
                $('#txtDriverLicenceNo').val(driver.licenceNo);
                $('#txtDriverName').val(driver.name);
                $('#txtDriverContactNo').val(driver.contactNo);
                $('#txtDriverNIC').val(driver.nic);
            }
        },
        error: function (ob) {
            swal({
                title: "Error!",
                text: "Drivers are not available in this time.Please try again shortly",
                icon: "error",
                button: "Close",
                timer: 2000
            });
        }
    })
}

function clearRentalDriverFields() {
    $('#txtDriverLicenceNo').val("");
    $('#txtDriverName').val("");
    $('#txtDriverContactNo').val("");
    $('#txtDriverNIC').val("");
}