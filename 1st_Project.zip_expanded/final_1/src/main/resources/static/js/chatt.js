window.onload=function(){
    let id = document.getElementById("id").value;
    let name = document.getElementById("name").value;
    console.log(name);
    if(id != null && id != ""){
        view();
    }
}

function getId(id){
    return document.getElementById(id);
}

var data = {};

var ws;
var name = getId('name');
var id = getId('id');
var btnLogin = getId('btnLogin');
var btnSend = getId('btnSend');
var talk = getId('talk');
var tcontent = getId('tcontent');

btnLogin.onclick = function(){
    ws = new WebSocket("ws://"+location.host+"/views");

    ws.onmessage = function(tcontent){
        var data = JSON.parse(tcontent.data);
        var css;

        if(data.name == name.value){
            css = 'class=me';
        }else{
            css = 'class=other';
        }
        
        let newDiv = document.createElement("div");
        let fieldset = document.getElementById("addele");
        let oldDiv = document.querySelector("fieldset>div");
        
        if(data.name == name.value){
            newDiv.setAttribute("class","me");
        }else {
            newDiv.setAttribute("class","other");
        }
        
        var item = `<span><b>${data.name}</b></span><div class="sd"> [ ${data.tdate} ]</div><br/>
                        <span>${data.tcontent}</span>`;
        newDiv.innerHTML += item;
        addele.insertBefore(newDiv, oldDiv);
        talk.scrollTop;
    }
}

tcontent.onkeyup = function(ev){
    if(ev.keyCode == 13){
        send();
    }
}

btnSend.onclick = function(){
    send();
}

function send(){
    if(tcontent.value.trim() != ''){
    	data.id = getId('id').value;
        data.name = getId('name').value;
        data.tcontent = tcontent.value;
        data.tdate = new Date().toLocaleString();
        var temp = JSON.stringify(data);
        ws.send(temp);
        $.ajax({
        	url:"/talk_db",
        	method:"post",
        	contentType:"application/json",
        	data:temp
        });
    }
    tcontent.value = '';
}

function view(){
	talkView.style.display = 'none';
    let image = document.getElementById("img");
    image.style.display = 'none';
	$.ajax({
		url:"/talkView",
		method:"post",
		dataType:"json",
		success:function(data){
                for(let i=0; i<data.length; i++){
                    let str = data[i];
                    let newDiv = document.createElement("div");
                    newDiv.setAttribute("class","other");
                    let fieldset = document.getElementById("addele");
                    let oldDiv = document.querySelector("fieldset>div");
                    var html = `<span><b>${str.name}</b></span><div class="sd"> [ ${str.tdate} ]</div><br/>
                                  <span>${str.tcontent}</span>`;
                    newDiv.innerHTML += html;
                    addele.insertBefore(newDiv, oldDiv); 
                };
        }
	});
		
}
