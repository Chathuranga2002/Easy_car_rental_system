const sign_in_btn = document.querySelector("#sign-in-btn");
const login = document.querySelector("#loginButton");
const signUp = document.querySelector("#btnSignUp");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");
const profileLink = document.getElementById("profileLink");

const baseUrl = "http://localhost:8080/BacEnd_war/";



sign_up_btn.addEventListener("click", () => {container.classList.add("sign-up-mode");});

sign_in_btn.addEventListener("click", () => {
    container.classList.remove("sign-up-mode");
});
//login
login.addEventListener("click",() =>{
    let userType =  $("#userType1").val();



    if (userType==='admin') {
        //  Admin logic
        let username = $('input[type="text"]').val();
        let password = $('input[type="password"]').val();
        $.ajax({
            url: baseUrl + "Admin/check?username="+username+"&password="+password,
            method: "post",
            data: "",
            dataType: "",
            success: function (res) {
                profileLink.href = `../pages/adminDashboard.html?username=${username}`;
                document.getElementById("profileLink").click();

                alert(res.message);
            },
            error: function (error) {
                alert(res.message);
            }
        });



    } else if (userType === 'customer') {
        //  Customer
        let username = $('input[type="text"]').val();
        let password = $('input[type="password"]').val();
        $.ajax({
            url: baseUrl + "Customer/check?username="+username+"&password="+password,
            method: "post",
            data: "",
            dataType: "",
            success: function (res) {
                profileLink.href = `../pages/CustomerDashboard.html?username=${username}`;
                document.getElementById("profileLink").click();

                alert(res.message);
            },
            error: function (error) {
                alert(res.message);
            }
        });



    } else if (userType === 'driver') {
        // Driver logic
        let username = $('input[type="text"]').val();
        let password = $('input[type="password"]').val();
        $.ajax({
            url: baseUrl + "Driver/check?username="+username+"&password="+password,
            method: "post",
            data: "",
            dataType: "",
            success: function (res) {

                profileLink.href = `../pages/DriverDashboard.html?username=${username}`;
                document.getElementById("profileLink").click();

                alert(res.message);
            },
            error: function (error) {
                alert(res.message);
            }
        });

    }

});


//sign up
$("#btnSignUp").click(function () {
    let formData = new FormData($("#signUpForm")[0]);
    $.ajax({
        url: baseUrl + "Customer",
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
    })
})




//
// signUp.addEventListener("click",() =>{
//     let formData = $("#signUpForm").serialize();
//     $.ajax({
//         url:baseUrl+"Customer",
//         method:"post",
//         data:formData,
//         dataType: "json",
//         success:function (res) {
//             //Invoked if the response status code is in 200 range
//             console.log("Success Method Invoked");
//             console.log(res);
//             alert(res.message);
//
//         },
//         error:function (error) {
//             //Invokes if status code range is 500 range or 400 range
//             console.log("Error Method Invoked");
//             console.log(JSON.parse(error.responseText));
//             alert(JSON.parse(error.responseText).message);
//         }
//     });
// });

// Function to extract the username from the URL query parameters
// function getUsernameFromURL() {
//     const urlParams = new URLSearchParams(window.location.search);
//     return urlParams.get("username");
// }
//
// // Get the username from the URL or set a default value
// const username = getUsernameFromURL(); // You can set your default username here.





