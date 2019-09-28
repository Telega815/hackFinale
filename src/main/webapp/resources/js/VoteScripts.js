
var questions = [];

function answChoise(event) {
    var qId = event.target.classList[0].split("_")[1];
    questions[qId] = event.target.id.split("_")[1];
}

function voteNow(event) {
    var qId = event.target.id.split("_")[1];
    var answ = questions[qId];

    $.ajax({
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        url: window.location.protocol + "//" + window.location.host + "/restService/VoteNow?qId="+qId+"&answ="+answ,
        method: 'GET',
        type: 'GET',

        success: function (data) {

        },
        error: function (e) {
            alert(e.responseText);
        }
    });

    event.stopPropagation();
}