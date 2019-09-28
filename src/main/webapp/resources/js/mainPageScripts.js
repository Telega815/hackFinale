function favoriteCategorySwitch (event) {
    //alert (likePlace);

    $.ajax({
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        url: window.location.protocol + "//" + window.location.host + "/restService/toggleHeart?heart="+event.target.id.split("_")[1],
        method: 'GET',
        type: 'GET',

        success: function (data) {

        },
        error: function (e) {
            alert(e.responseText);
        }
    });


    if (event.target.classList.contains("heart_open")) {
        event.target.classList.remove("heart_open");
        event.target.classList.add("heart_close");
        event.target.src = window.location.protocol + "//" + window.location.host + "//resources/media/like_close.png";
    }else{
        event.target.classList.remove("heart_close");
        event.target.classList.add("heart_open");
        event.target.src = window.location.protocol + "//" + window.location.host + "//resources/media/like_open.png";
    }
    event.stopPropagation();

}