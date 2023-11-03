const BASE_URL ="http://localhost:8080/BacEnd_war/";
//========================DriverController========================================
// getAllDrivers();
// save Driver
$("#btnSaveDrivers").click(function () {
    console.log("sss")
    let formData = $("#DriverFormData").serialize();

    $.ajax({
        url:BASE_URL+"Driver",
        method:"post",
        data:formData,
        dataType: "json",
        success:function (res) {
            //Invoked if the response status code is in 200 range
            console.log("Success Method Invoked");
            console.log(res);
            alert(res.message);
            // getAllCars();
        },
        error:function (error) {
            //Invokes if status code range is 500 range or 400 range
            console.log("Error Method Invoked");
            console.log(JSON.parse(error.responseText));
            alert(JSON.parse(error.responseText).message);
        }
    });

});

// get all Drivers
function getAllDrivers() {
    $("#tblRegisteredDrivers").empty();

    $.ajax({
        url: BASE_URL +'Driver',
        dataType: "json",
        success: function (response) {
            let drivers = response.data;
            for (let i in drivers) {
                let dri = drivers[i];

                let licenceNo = dri.licenceNo;
                let nic = dri.nic;
                let name = dri.name;
                let address = dri.address;
                let tel = dri.contactNo;
                let userName = dri.username;
                let password = dri.password;
                let availability = dri.availability;

                let row = `<tr><td>${licenceNo}</td><td>${nic}</td><td>${name}</td><td>${address}</td><td>${tel}</td><td>${userName}</td><td>${password}</td><td>${availability}</td></tr>`;
                $("#tblRegisteredDrivers").append(row);
                bindRowClickEvents();
                setTextFieldValues("","","","","","","","");
            }
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}



//========================CarController========================================
/*Save Car*/
$("#BtnSaveCar").click(function () {

    let formData = $("#CarForm1").serialize();

    $.ajax({
        url:BASE_URL+"Car",
        method:"post",
        data:formData,
        dataType: "json",
        success:function (res) {
            //Invoked if the response status code is in 200 range
            console.log("Success Method Invoked");
            console.log(res);
            alert(res.message);

        },
        error:function (error) {
            //Invokes if status code range is 500 range or 400 range
            console.log("Error Method Invoked");
            console.log(JSON.parse(error.responseText));
            alert(JSON.parse(error.responseText).message);
        }
    });

});
