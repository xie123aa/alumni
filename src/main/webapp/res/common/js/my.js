
$(document).ready(function () {
    $("#btn").on("click",function () {
        var comment= $("#comment").val()
        $.post(domain+"/reply.action",{ comment:comment,id: id},function (data) {
            $("#append").append("<p>"+name+":"+data.comment+"</p>");
        });
    });
});