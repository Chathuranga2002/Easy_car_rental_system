
getAllDrivers();
/*Save driver*/
$("#btnSaveDrivers").click(function () {
    console.log("sss")
    let formData = $("#DriverFormData").serialize();

    $.ajax({
        url:baseUrl+"Driver",
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
        url: baseUrl +'Driver',
        dataType: "json",
        success: function (response) {
            let drivers = response.data;
            for (let i in drivers) {
                let dri = drivers[i];

                let nic = dri.nic;
                let name1 = dri.name;
                let address1 = dri.address;
                let tel = dri.contactNo;
                let userName = dri.username;
                let availability = dri.availability;
                let liNo = dri.licenceNo;

                let row = `<tr><td>${nic}</td><td>${name1}</td><td>${tel}</td><td>${availability}</td><td>${address1}</td><td>${liNo}</td><td>${userName}</td></tr>`;
                $("#tblRegisteredDrivers").append(row);
                // bindRowClickEvents();
                // setTextFieldValues("","","","","","","");
            }
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}
