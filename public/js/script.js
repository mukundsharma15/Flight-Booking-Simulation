$(document).ready(function () {
    M.AutoInit();

    var elems = document.querySelectorAll('.datepicker');
    var instances = M.Datepicker.init(elems, {
        format: 'yyyy-mm-dd',
    });
});

function store(key, value) {
    localStorage.setItem(key, JSON.stringify(value));
}

function retrieve(key) {
    return JSON.parse(localStorage.getItem(key));
}

function remove(key) {
    return localStorage.removeItem(key);
}

function login() {

    axios({
        method: 'post',
        url: 'http://localhost:8080/user/login',

        data: {
            email: $('#email').val(),
            password: $('#password').val()
        }
    })
        .then(function (response) {
            if (response.data.validCredentials) {
                store('user', response.data.user);
                window.location.href = 'http://localhost:8080/dashboard.html';
            } else {
                window.location.href = 'http://localhost:8080/login.html';
            }
        })
}

function signup() {

    axios({
        method: 'post',
        url: 'http://localhost:8080/user/signup',

        data: {
            userType: $('#userType').val(),
            firstName: $('#fname').val(),
            lastName: $('#lname').val(),
            password: $('#password').val(),
            address: $('#address').val(),
            dob: $('#dob').val(),
            photoId: $('#photoid').val(),
            mobileNo: $('#mobile').val(),
            email: $('#email').val(),
            gender: $('#gender').val()
        }
    })
        .then(function (response) {
            if (response.data.success) {
                window.location.href = 'http://localhost:8080/login.html';
            } else {
                window.location.href = 'http://localhost:8080/signup.html';
            }
        })

}

function search() {

    store('search', {
        origin: $('#origin').val(),
        destination: $('#destination').val(),
        numberOfPassengers: $('#passengers').val(),
    });

    axios({
        method: 'post',
        url: 'http://localhost:8080/search/search',

        data: {
            origin: $('#origin').val(),
            destination: $('#destination').val(),
            departureDate: $('#departure').val(),
            returnDate: $('#arrival').val(),
            numberOfPassengers: $('#passengers').val(),
            flightClass: $('#flightClass').val(),
            flightType: $('#flightType').val()
        },
        headers: {
            'Content-Type': 'application/json',
            'userid': retrieve('user').userId
        }
    })
        .then(function (response) {
            if (response.data.success) {

                let resultsHtml = '';
                response.data.results.forEach(el => {
                    const escapedObject = encodeURIComponent(JSON.stringify(el));
                    resultsHtml += `
                    <div class="collection-item">
                        Airlines: ${el.airlines}<br>
                        Airport: ${el.airport}<br>
                        Flight Number: ${el.flightNumber}<br>
                        Flight Duration: ${el.flightDuration} minutes<br>
                        Departure Time: ${el.departureTime}<br>
                        Arrival Time: ${el.arrivalTime}<br>
                        DepartureDate: ${el.departureDate}<br>
                        Arrival Date: ${el.arrivalDate}<br>
                        Price: ${el.price}<br>
                        <br>
                        <button class="btn waves-effect waves-light" type="submit" name="action" onclick="bookAction('${escapedObject}')">Checkout</button>
                        <br>
                    </div>
                    `
                });

                $('#SearchResults').html(resultsHtml);

            } else {

            }
        })
}

function bookAction (obj) {
    const object = JSON.parse(decodeURIComponent(obj));
    store('booking', object);
    window.location.href = 'http://localhost:8080/checkout.html';
}

function book () {

    const booking = retrieve('booking');
    const search = retrieve('search');
    const user = retrieve('user');

    axios({
        method: 'post',
        url: 'http://localhost:8080/flightbook/booking',

        data: {
            userId: user.userId,
            userType: user.userType,
            firstName: user.firstName,
            lastName: user.lastName,
            airlines: booking.airlines,
            airport: booking.airport,
            flightNumber: booking.flightNumber,
            price: booking.price,
            extraBaggage: parseInt($('#bags').val()),
            validProofID: $('#idproof').val(),
            seatInformation: parseInt($('#seat').val()),
            insurance: $('#insurance').val(),
            origin: search.origin,
            destination: search.destination,
            departureDate: booking.departureDate,
            returnDate: booking.arrivalDate,
            numberOfPassengers: search.numberOfPassengers,
            flightClass: booking.flightClass,
            flightType: booking.flightType
        },
        headers: {
            'Content-Type': 'application/json',
            'userid': retrieve('user').userId
        }
    })
        .then(function (response) {
            if (response.data.success) {
                window.location.href = 'http://localhost:8080/dashboard.html';
            }
        })
}

function bookings() {
    window.location.href = 'http://localhost:8080/managebooking.html';
}

function deleteBooking(){
    axios({
        method: 'post',
        url: 'http://localhost:8080/manageBooking/booking/delete',
        data: {
            pnr: $('#pnr').val()
        },
        headers: {
            'Content-Type': 'application/json',
            'userid': retrieve('user').userId
        }
    })
        .then(function (response) {
            if (response.data.success) {
                window.location.href = 'http://localhost:8080/managebooking.html';
            }
        })
}

function editBookingDone(){
    const form = document.getElementById('editbookingform');
    const baggage = form.baggage.value
    const insurance = form.insurance.value
    const flightclass = form.flightclass.value
    const passengers = form.passengers.value
    const seatinfo = form.seatinfo.value

    axios({
        method: 'post',
        url: 'http://localhost:8080/manageBooking/booking/edit',
        data: {
            pnr: $('#pnr').val(),
            extraBaggage: $('#baggage'),
            insurance: $('#insurance'),
            flightClass: $('#flightclass'),
            numberOfPassengers: $('#passengers'),
            seatInformation: $('#seatinfo')
        }
    })
        .then(function (response) {
            if (response.data.success) {
                window.location.href = 'http://localhost:8080/managebooking.html';
            }
        })
}

function editBooking() {
    axios({
        method: 'post',
        url: 'http://localhost:8080/manageBooking/bookings',
        data: {
            pnr: $('#pnr').val(),
            lastName: $('#lastname').val(),
        },
        headers: {
            'Content-Type': 'application/json',
            'userid': retrieve('user').userId
        }
    })
        .then(function (response) {
            if (response.data.success) {
                let resultsHtml = '';
                response.data.results.forEach(el => {
                    resultsHtml += `
                        <form class="collection-item" id="editbookingform">
                            Number of Bags<input type="text" id="baggage", value=${el.extraBaggage}>
                            Insurance<input type="text" id="insurance", value=${el.insurance}>
                            Flight Class<input type="text" id="flightclass", value=${el.flightClass}>
                            Passengers<input type="text" id="passengers", value=${el.numberOfPessengers}>
                            Seat Info<input type="text" id="seatinfo", value=${el.seatInformation}>
                            <button class="btn waves-effect waves-light" type="submit" onclick="editBookingDone()"> Update </button>
                        </form>
                        `
                });

                $('#SearchResults').html(resultsHtml);
            } else {
            }
        })
}

function managebooking() {
    axios({
            method: 'post',
            url: 'http://localhost:8080/manageBooking/bookings',

            data: {
                pnr: $('#pnr').val(),
                lastName: $('#lastname').val(),
            },
            headers: {
                'Content-Type': 'application/json',
                'userid': retrieve('user').userId
            }
        })
            .then(function (response) {
                if (response.data.success) {
                    let resultsHtml = '';
                    response.data.results.forEach(el => {
                        resultsHtml += `
                        <div class="collection-item">
                            First Name: ${el.firstName}<br>
                            Last Name: ${el.lastName}<br>
                            Origin: ${el.origin}<br>
                            Destination: ${el.destination}<br>
                            Departure Date: ${el.departureDate}<br>
                            Return Date: ${el.returnDate}<br>
                            Seat Info: ${el.seatInfo}<br>
                            Price: ${el.price}<br>
                        </div>
                        <div class="collection-item">
                            <button class="btn waves-effect waves-light" type="submit" onclick="editBooking()">Edit Booking</button>
                            <button class="btn waves-effect waves-light" type="submit" onclick="deleteBooking()">Delete Booking</button>
                        </div>
                        `
                    });

                    $('#SearchResults').html(resultsHtml);
                } else {
                }
            })
}