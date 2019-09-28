
var questions = [];

document.addEventListener("DOMContentLoaded", function() {
    _.templateSettings = {
        interpolate: /\<\@\=(.+?)\@\>/gim,
        evaluate: /\<\@([\s\S]+?)\@\>/gim,
        escape: /\<\@\-(.+?)\@\>/gim
    };
    tmpl = _.template(document.getElementById('questionTemplate').innerHTML);
});


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
            var answs = document.getElementById("answers_"+data.id);
            answs.innerHTML = "";


            var wrapper = document.getElementById("qSubmitWrapper_"+data.id);
            var submit = document.getElementById("qSubmit_"+data.id);
            submit.disabled = true;
            // wrapper.innerHTML = "";

            var len = data.resList.length;
            var list = data.resList;
            list.sort(function(a, b) {
                return a.id - b.id;
            });

            for (var i = 0; i < len; i++){
                var newTmpl = showQuestion(data.resList[i]);
                answs.innerHTML = answs.innerHTML + newTmpl;
            }

            var span = document.createElement('span');
            span.innerHTML = "Проголосовали "+data.votecount+" человек";
            wrapper.appendChild(span);
        },
        error: function (e) {
            alert(e.responseText);
        }
    });

    event.stopPropagation();
}

function showQuestion(answer) {
    var newTmpl = tmpl({
        percent: answer.percent,
        description: answer.description
    });

    // var wrapper= document.createElement('div');
    // wrapper.innerHTML= newTmpl;

    return newTmpl;
}