
searchCustomerByIdForRespond();
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
//===================================Add rent================================
$('#sendRequest').click(function () {
    let regNo = $('#cmbRegistrationNo').find('option:selected').text();
    if (regNo != "" && regNo != "-Select Registration No-" && $('#txtCarPickupDate').val()!="" ) {
        searchCustomerById(username);
    } else {
        alert("Please fill rental fields");

    }
})


function searchCustomerById(username) {
    $.ajax({
        url: baseUrl + "Customer/" + username,
        method: "GET",
        success: function (res) {
            let customer = res.data;
            console.log(customer);
            searchCurById(customer);

        }
    });

}
function searchCurById(customer) {
    let regisrId = $('#cmbRegistrationNo').find('option:selected').text();

    $.ajax({
        url: baseUrl+"Car",
        success:function (res) {
            for (let c of res.data) {
                let carID=c.registrationNO;
                if (carID == regisrId) {
                    let car=c;
                    console.log(car)
                    searchDriverByNic(customer, car)
                }
            }

        },
        error:function (error) {
            let message= JSON.parse(error.responseText).message;
            alert(message);
        }
    });

}


function searchDriverByNic(customer, car) {
    let licenceNo = $('#txtDriverNIC').val();
    if ($('#txtDriverNIC').val() === "") {
        licenceNo = null;
    }

    if (licenceNo != null) {
        $.ajax({
            url: baseUrl+"Driver",
            success:function (res) {
                for (let c of res.data) {
                    let drNic=c.nic;
                    if (drNic == licenceNo) {
                        let driver=c;
                        console.log(driver)
                        addCarRent(customer, car, driver);
                    }
                }

            },
            error:function (error) {
                let message= JSON.parse(error.responseText).message;
                alert(message);
            }
        });

    } else {
        addCarRent(customer, car, null);

    }
}

function addCarRent(customer, car, driver) {

    let rentId = $('#txtCarRentId').val();
    let advance = $('#txtPaymentAmount').val();
    let dayCount = $('#txtRantDayCount').val();
    let pickUpDate = $('#txtCarPickupDate').val();
    let rentType = $('#cmbRentType').find('option:selected').text();
    let status = "Pending";
    let carRent = {
        rentId: rentId,
        advance: advance,
        dayCount: dayCount,
        pickUpDate: pickUpDate,
        rentType: rentType,
        status: status,
        customer: customer,
        car: car,
        driver: driver
    }

    let carData =JSON.stringify(carRent);

    $.ajax({
        url: baseUrl + "CarRent",
        method: "post",
        data: carData,
        dataType: "json",
        contentType: "application/json",
        success: function (rep) {
            searchCustomerByIdForRespond();
            refreshAddRent();
            generateNextCarRentId();
            swal({
                title: "Confirmation",
                text: "Rental Request send successfully",
                icon: "success",
                button: "Close",
                timer: 2000
            });
        },
        error: function (ob) {

            alert(ob.message);
            swal({
                title: "Error",
                text: "Error Occured.Please Try Again.",
                icon: "error",
                button: "Close",
                timer: 2000
            });
        }
    })
}
//-=============================================================================================

function searchCustomerByIdForRespond() {
        $.ajax({
            url: baseUrl + "Customer/" + username,
            method: "GET",
            success: function (res) {
                let customer = res.data;

                loadMyRentId(customer.nicNo);

            }
        });

}


function loadMyRentId(nicNo) {
        $.ajax({
            url:"http://localhost:8080/BacEnd_war/CarRent/getMyCarRents/"+nicNo,
            method:"GET",
            success:function (res) {
                for (let carRent of res.data) {
                    let rent=carRent.rentId;
                    $("#CombRentId").append(`<option value="${rent}">${rent}</option>`);
                }
            }
        })
}

$("#CombRentId").change(function () {
    let code = $("#CombRentId").val();
    $.ajax({
        url:"http://localhost:8080/BacEnd_war/CarRent/"+code,
        method:"GET",
        success:function (res) {
            let rent=res.data;
          $("#txtPickupDate").val(rent.pickUpDate);
          $("#txtType").val(rent.rentType);
          $("#txtDayCount").val(rent.dayCount);
          $("#txtStatus").val(rent.status);
        }
    })

});

$('#btnClearRental').click(function () {
    refreshRentView();
});






function refreshRentView() {
    $(".rentview").val("");
}
//===================delete rent
$('#btnDeleteRental').click(function () {
    cancealedRental($("#CombRentId").val());
});
$('#btnCancleRental').click(function () {
    refreshAddRent();
});


function cancealedRental(rentId) {
    let status = "Canceled";
    $.ajax({
        url:  "http://localhost:8080/BacEnd_war/CarRent/" + rentId + "/" + status,
        method: "PUT",
        success: function (res) {
            refreshRentView();
            swal({
                title: "Confirmation!",
                text: "Car Rental Accepted Successfully",
                icon: "success",
                button: "Close",
                timer: 2000
            });
        },
        error: function (ob) {
            swal({
                title: "Confirmation!",
                text: "Car Rental Accepted Successfully",
                icon: "success",
                button: "Close",
                timer: 2000
            });
        }
    })
}

function refreshAddRent() {
    $(".bookT").val("");
    $(".refresh").attr("src","");
}