
$(function () {
    alert('请点击开始呢')
    var url = '/list';
    $.ajax({
        url:url,
        type:'get',
        data:{},
        success:function (data) {
            alert('请  项目可抵扣')
            var label = document.getElementById("label").innerHTML=data.name;
        },
        error:function (data) {
            alert('djcnjdnck');
        }

    })
    
})