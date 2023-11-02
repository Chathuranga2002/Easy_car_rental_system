// let baseUrl="http://localhost:8081/easycarrental/"
let baseUrl= "http://localhost:8080/BacEnd_war/";

// getAllCars();
/*Save Car*/
$("#BtnSaveCar").click(function () {

   let formData = $("#CarForm1").serialize();

   $.ajax({
       url:baseUrl+"Car",
       method:"post",
       data:formData,
       dataType: "json",
       success:function (res) {
           //Invoked if the response status code is in 200 range
           console.log("Success Method Invoked");
           console.log(res);
           alert(res.message);
           getAllCars();
       },
       error:function (error) {
           //Invokes if status code range is 500 range or 400 range
           console.log("Error Method Invoked");
           console.log(JSON.parse(error.responseText));
           alert(JSON.parse(error.responseText).message);
       }
   });

});

/*Save Car*/
$("#BtnDelCar").click(function () {
    let img =$("#backViewImg");
    console.log(img)
});



// //Delete Car
// $("#btnDeleteCar").click(function () {
//    let registrationNO = $("#txtCarRegId").val();
//    $.ajax({
//        url:baseUrl+"car?registrationNO="+registrationNO,
//        method: "delete",
//        success:function (resp) {
//            getAllCars();
//            alert(resp.message);
//        },
//        error:function (error) {
//            let message= JSON.parse(error.responseText).message;
//            alert(message);
//        }
//    });
// });
//
//
//
// /*Update Car*/
// $("#btnUpdateCar").click(function () {
//
//     let carID = $("#txtCarRegId").val();
//     let carBrand = $("#txtCarBrand").val();
//     let carType = $("#cmbCartype").val();
//     let carPassengersCount = $("#txtCarNoOfPassengers").val();
//     let carTransmissionType = $("#cmbCarTransmissionType").val();
//
//     let carFuelType = $("#cmbCarFuel").val();
//     let carColor = $("#cmbCarColor").val();
//     let carCompleteKm = $("#txtCarCompleteKM").val();
//     let carImages = $("#imgFrontView").val();
//     let carStatus = $("#txtCarStatus").val();
//
//     var carOb={
//           registrationNO:carID,
//           brand:carBrand,
//           type:carType,
//           passengersCount:carPassengersCount,
//           transmissionType:carTransmissionType,
//
//           fuelType:carFuelType,
//           color:carColor,
//           completeKm:carCompleteKm,
//           images:carImages,
//           status:carStatus
//     }
//
//     $.ajax({
//         url:baseUrl+"car",
//         method:"put",
//         contentType:"application/json",
//         data: JSON.stringify(carOb),
//         dataType: "json",
//         success:function (resp) {
//             getAllCars();
//             alert(resp.message);
//         },
//         error:function (error) {
//             let message= JSON.parse(error.responseText).message;
//             alert(message);
//         }
//     });
// });
//
//
//
// $("#btnGetAllCar").click(function () {
//     getAllCars();
// });
// function getAllCars() {
//     $("#tblCar").empty();
//     $.ajax({
//         url: baseUrl+"car",
//         success:function (res) {
//             for (let c of res.data) {
//                 let carID=c.registrationNO;
//                 let carBrand=c.brand;
//                 let carType=c.type;
//                 let carPassengersCount=c.passengersCount;
//                 let carTransmissionType=c.transmissionType;
//
//                 let carFuelType=c.fuelType;
//                 let carColor=c.color;
//                 let carCompleteKm=c.completeKm;
//                 let carImages=c.images;
//                 let carStatus=c.status;
//
//
//                 let row= "<tr><td>"+carID+"</td><td>"+carBrand+"</td><td>"+carType+"</td><td>"+carPassengersCount+"</td><td>"+carTransmissionType+"</td><td>"+carFuelType+"</td><td>"+carColor+"</td><td>"+carCompleteKm+"</td><td>"+carImages+"</td><td>"+carStatus+"</td></tr>";
//                 $("#tblCar").append(row);
//             }
//             bindRowClickEvents();
//             setTextFieldValues("","","","","","","","","","");
//         },
//         error:function (error) {
//             let message= JSON.parse(error.responseText).message;
//             alert(message);
//         }
//     });
// }
//
// //Bind events for the table rows function
// function bindRowClickEvents() {
//     $("#tblCar>tr").click(function () {
//         let registrationNO = $(this).children(":eq(0)").text();
//         let brand = $(this).children(":eq(1)").text();
//         let type = $(this).children(":eq(2)").text();
//         let passengersCount = $(this).children(":eq(3)").text();
//         let transmissionType = $(this).children(":eq(4)").text();
//         let fuelType = $(this).children(":eq(5)").text();
//         let color = $(this).children(":eq(6)").text();
//         let completeKm = $(this).children(":eq(7)").text();
//         let images = $(this).children(":eq(8)").text();
//         let status = $(this).children(":eq(9)").text();
//
//
//         $('#txtCarRegId').val(registrationNO);
//         $('#txtCarBrand').val(brand);
//         $('#cmbCartype').val(type);
//         $('#txtCarNoOfPassengers').val(passengersCount);
//         $('#cmbCarTransmissionType').val(transmissionType);
//
//         $('#cmbCarFuel').val(fuelType);
//         $('#cmbCarColor').val(color);
//         $('#txtCarCompleteKM').val(completeKm);
//         $('#imgFrontView').val(images);
//         $('#txtCarStatus').val(status);
//
//     });
// }
//
//
// //Set text fields values function
// function setTextFieldValues(registrationNO, brand, type, passengersCount, transmissionType, fuelType, color, completeKm,images, status ) {
//     $("#txtCarRegId").val(registrationNO);
//     $("#txtCarBrand").val(brand);
//     $("#cmbCartype").val(type);
//     $("#txtCarNoOfPassengers").val(passengersCount);
//     $("#cmbCarTransmissionType").val(transmissionType);
//
//     $("#cmbCarFuel").val(fuelType);
//     $("#cmbCarColor").val(color);
//     $("#txtCarCompleteKM").val(completeKm);
//     $("#imgFrontView").val(images);
//     $("#txtCarStatus").val(status);
//
// }
//
//
//
//
//
// /*
// registrationNO brand type passengersCount
//   transmissionType fuelType color
//       completeKm status   images  */
//
