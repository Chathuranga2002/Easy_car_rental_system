 refreshRentView();
 // getAllrentid();

// function getAllrentid() {
//     $.ajax({
//         url: baseUrl +'CarRent',
//         dataType: "json",
//         success: function (response) {
//             let rent = response.data;
//             for (let i in rent) {
//                 let re = rent[i];
//
//                 let rentId = re.rentId;
//                 $("#cmbPaymentId").append(`<option value="${rentId}">${rentId}</option>`);
//             }
//         },
//         error: function (error) {
//             alert(error.responseJSON.message);
//         }
//     });
// }


function refreshRentView() {
    $("#tblCarRentals").empty();
    $.ajax({
        url: baseUrl +'CarRent',
        dataType: "json",
        success: function (response) {
            let rent = response.data;
            for (let i in rent) {
                let re = rent[i];

                let rentId = re.rentId;
                let cusid = re.nicNo;
                let driverNIC = re.driverNIC;
                let registrationNO = re.registrationNO;
                let pickUpDate = re.pickUpDate;
                let rentType = re.rentType;
                let dayCount = re.dayCount;

                let row = `<tr><td>${rentId}</td><td>${cusid}</td><td>${driverNIC}</td><td>${registrationNO}</td><td>${pickUpDate}</td><td>${rentType}</td><td>${dayCount}</td></tr>`;
                $("#tblCarRentals").append(row);
                // bindRowClickEvents();
                // setTextFieldValues("","","","","","","");
            }
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}


 $("#txtRentId").on("keydown", function(event) {
     if (event.keyCode === 13) {
         // Enter key is pressed
         let enteredText = $(this).val();
         console.log(enteredText)
         $.ajax({
             url: baseUrl +'CarRent',
             dataType: "json",
             success: function (response) {
                 let rent = response.data;
                 for (let i in rent) {
                     let re = rent[i];


                     if (re.rentId==enteredText){
                         $("#txtPaymentAdvance").val(re.advance);

                     }

                 }
             },
             error: function (error) {
                 alert(error.responseJSON.message);
             }
         });
     }
 });
 $('#btnAcceptCustomer').click(function () {
     console.log("hh")
     AcseptCustomer($("#txtCustomerId").val());

 });


 function AcseptCustomer(nicNo) {
     let status = "Accept";
     $.ajax({
         url:  "http://localhost:8080/BacEnd_war/Customer/" + nicNo + "/" + status,
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



 //
 // $("#cmbPaymentId").change(function () {
 //     let selectedValue = $("#CombRentId").val();
 //     console.log(selectedValue);
 //
 //
 // });