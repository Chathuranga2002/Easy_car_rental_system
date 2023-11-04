
function getUsernameFromURL() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get("username");
}

    const username = getUsernameFromURL();
console.log(username);
    // searchCustomerById(username);
searchDriverByUsername();

// get Driver
function searchDriverByUsername() {

        $.ajax({
            url: "http://localhost:8080/BacEnd_war/Driver/user/"+username,
            method: "GET",
            success: function (res) {
                let driver = res.data;
                console.log(driver.nic);
                loadDriverSchedule(driver.nic);
            }
        })

}



function loadDriverSchedule(licenceNo) {
    $('#bookingScheduleTable').empty();
    let status = "Pending";
    $.ajax({
        url:"http://localhost:8080/BacEnd_war/CarRent/getCarRents/"+status+"/"+licenceNo,
        method:"GET",
        success:function (res) {
            for (let carRent of res.data) {
                let row = `<tr><td>${carRent.rentId}</td><td>${carRent.customer.name}</td><td>${carRent.customer.contactNo}</td><td>${carRent.rentType}</td><td>${carRent.car.registrationNO}</td><td>${carRent.pickUpDate}</td><td>${carRent.dayCount}</td></tr>`;
                $('#tblDriverDashBord').append(row);
            }
        }
    })
}