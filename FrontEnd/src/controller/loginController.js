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
               if (res.message=="true"){
                   profileLink.href = `../pages/adminDashboard.html?username=${username}`;
                   document.getElementById("profileLink").click();
                   swal({
                       title: "Confirmation",
                       text: "Login successfully",
                       icon: "success",
                       button: "Close",
                       timer: 2000
                   });
               }else {
                   refresh();
                   swal({
                       title: "error",
                       text: "Invalid Username Or Password",
                       icon: "error",
                       button: "Close",
                       timer: 2000
                   });

               }

            },
            error: function (ob) {

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
                if (res.message=="true"){
                profileLink.href = `../pages/CustomerDashboard.html?username=${username}`;
                document.getElementById("profileLink").click();
                    swal({
                        title: "Confirmation",
                        text: "Login  successfully",
                        icon: "success",
                        button: "Close",
                        timer: 2000
                    });
                }else {
                    refresh();
                    swal({
                        title: "error",
                        text: "Invalid Username Or Password",
                        icon: "error",
                        button: "Close",
                        timer: 2000
                    });
                }

            },
            error: function (res) {

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
                if (res.message=="true"){
                profileLink.href = `../pages/DriverDashboard.html?username=${username}`;
                document.getElementById("profileLink").click();

                swal({
                    title: "Confirmation",
                    text: "Login  successfully",
                    icon: "success",
                    button: "Close",
                    timer: 2000
                });
            }else {
                    refresh();
                    swal({
                             title: "error",
                             text: "Invalid Username Or Password",
                             icon: "error",
                             button: "Close",
                             timer: 2000
                         });
                }
            },
            error: function (error) {

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
            refresh2();
            swal({
                title: "Confirmation",
                text: "Login  successfully",
                icon: "success",
                button: "Close",
                timer: 2000
            });
        },
        error: function (rep) {
            swal({
                title: "error",
                text: "Invalid Username Or Password",
                icon: "error",
                button: "Close",
                timer: 2000
            });
        }
    })
})

function refresh() {
    $("#txtLoginusaername,#txtLoginPass").val("");
}

function refresh2() {
    $(".in").val("");
}



