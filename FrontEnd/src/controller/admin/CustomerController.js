getAllCustomer();


// Get a reference to the table body
var tableBody = document.getElementById("tblPendingCustomers");

// Add a click event listener to the table body
tableBody.addEventListener("click", function (event) {
    // Check if the clicked element is a table cell (td)
    if (event.target.tagName === "TD") {
        // Get the data from the clicked row and assign it to variables
        var row = event.target.parentNode;

        var username = row.cells[4].textContent;

        // Now you can use these variables as needed
            $.ajax({
        url: baseUrl + "Customer/" + username,
        method: "GET",
        success: function (res) {
            let customer = res.data;
            console.log(customer);
            let img = "../../../Easy_car_rental_system/BacEnd/src/main/resources/file/" + customer.nicFrontImg;
            let imgView = $("#NicImgView");
            imgView.attr("src", img);

            $('#txtCustomerId').val(customer.nicNo);
            $('#txtCustomerName').val(customer.name);
            $('#txtCustomerContactNo').val(customer.contactNo);
            $('#txtCustomerEmail').val(customer.email);
            $("#txtCustomerUserName").val(customer.username);
        }
    });


    }
});


$("#btnClearFields").click(function () {
   getAllCustomer();
});

// get all customer
function getAllCustomer() {
    $("#tblPendingCustomers").empty();

    $.ajax({
        url: baseUrl +'Customer',
        dataType: "json",
        success: function (response) {
            let customer = response.data;
            for (let i in customer) {
                let c = customer[i];

                let nic = c.nicNo;
                let name1 = c.name;
                let email = c.email;
                let tel = c.contactNo;
                let user = c.username;
                let address1 = c.address;
                let availability = c.status;

                let row = `<tr><td>${nic}</td><td>${name1}</td><td>${email}</td><td>${tel}</td><td>${user}</td><td>${address1}</td><td>${availability}</td></tr>`;
                $("#tblPendingCustomers").append(row);
                // bindRowClickEvents();
                // setTextFieldValues("","","","","","","");
            }
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}


