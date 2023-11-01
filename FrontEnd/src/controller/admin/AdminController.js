const BASE_URL = "http://localhost:8080/BacEnd_war/";

// save Driver
$("#btnSaveDriver").click(function () {
    let formData = $("#driverRegFrom").serialize();

    console.log(formData);

    // $.ajax({
    //     url: BASE_URL + "driver",
    //     method: "post",
    //     data: formData,
    //     dataType: "json",
    //     success: function (res) {
    //         alert(res.message);
    //         getAllDrivers();
    //     },
    //     error: function (error) {
    //         alert(error.responseJSON.message);
    //     }
    // });
});