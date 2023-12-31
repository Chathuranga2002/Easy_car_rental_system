let selectedCarForRent;
let selectedDriverForRent;


/*Save Car*/
$("#BtnSaveCar").click(function () {

    let formData = new FormData($("#CarForm1")[0]);
    formData.forEach((value, key) => {
        console.log(key, value);
    });
    $.ajax({
        url: baseUrl + "Car",
        method: "POST",
        data: formData,
        contentType: false,
        processData: false,
        success: function (rep) {
            alert(rep.message);

        },
        error: function (rep) {
            alert(rep.message);
        }
    });
});
   // $.ajax({
   //     url:baseUrl+"Car",
   //     method:"post",
   //     data:formData,
   //     dataType: "json",
   //     success:function (res) {
   //         //Invoked if the response status code is in 200 range
   //         console.log("Success Method Invoked");
   //         console.log(res);
   //         alert(res.message);
   //         // getAllCars();
   //     },
   //     error:function (error) {
   //         //Invokes if status code range is 500 range or 400 range
   //         console.log("Error Method Invoked");
   //         console.log(JSON.parse(error.responseText));
   //         alert(JSON.parse(error.responseText).message);
   //     }
   // });



function getAllCarsId(code) {
    $("#cmbRegistrationNo").empty();
    $.ajax({
        url: baseUrl+"Car",
        success:function (res) {
            for (let c of res.data) {
                let carType=c.type;
                let carID=c.registrationNO;
                let stutus=c.status;
                // if (code == carType) {
                //     // $("#cmbRegistrationNo").append(`<option value="${carID}">${carID}</option>`);
                //  }
                if (code == carType) {
                    if (stutus !== "rent" || stutus !== "maintain") {
                        // Your additional logic here
                        $("#cmbRegistrationNo").append(`<option value="${carID}">${carID}</option>`);
                    }
                }




            }

        },
        error:function (error) {
            let message= JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}










$("#cmbType").change(function () {
    let code = $("#cmbType").val();
    getAllCarsId(code);

});


$(".regNO").click(function () {
    let regNO = $("#cmbRegistrationNo").val();
    $.ajax({
        url: baseUrl+"Car",
        success:function (res) {
            for (let c of res.data) {
                let carID=c.registrationNO;
                if (regNO == carID) {
                    selectedCarForRent=c;
                    console.log(selectedCarForRent);
                    let front_img = "../../../Easy_car_rental_system/BacEnd/src/main/resources/Car/"+c.frontViewImg;
                    let side_img = "../../../Easy_car_rental_system/BacEnd/src/main/resources/Car/" + c.sideViewImg;
                    let back_img = "../../../Easy_car_rental_system/BacEnd/src/main/resources/Car/" + c.backViewImg;
                    let interior_img = "../../../Easy_car_rental_system/BacEnd/src/main/resources/Car/" + c.internalViewImg;

                    var imgCarFrontView = $("#CarFrontView");
                    var imgCarBackView = $("#CarBackView");
                    var imgSideView = $("#CarSideView");
                    var imgCarInteriorView = $("#CarInteriorView");

                    imgCarFrontView.attr("src", front_img);
                    imgCarBackView.attr("src", side_img);
                    imgSideView.attr("src", back_img);
                    imgCarInteriorView.attr("src", interior_img);

                    $("#txtCarBrand").val(c.brand);
                    $("#txtCarColor").val(c.color);
                    $("#txtCarFuel").val(c.fuelType);
                    $("#txtCarNoOfPassengers").val(c.passengersCount);
                    $("#txtCarTransmission").val(c.transmissionType);
                    $("#txtCarFreeKmForDay").val(c.freeKmForDay);
                    $("#txtCarDailyRate").val(c.dailyRate);
                    $("#txtCarFreeKmForMonth").val(c.freeKmForMonth);
                    $("#txtCarMonthlyRate").val(c.monthlyRate);
                    $("#txtCarPriceForExtraKm").val(c.pricePerExtraKm);

                }
            }

        },
        error:function (error) {
            let message= JSON.parse(error.responseText).message;
            alert(message);
        }
    });

});
