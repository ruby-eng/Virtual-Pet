async function update(){

const res = await fetch("http://localhost:8080/pet");
const data = await res.json();

document.getElementById("hunger").innerText = data.hunger;
document.getElementById("happiness").innerText = data.happiness;
document.getElementById("energy").innerText = data.energy;

}

async function feed(){
await fetch("http://localhost:8080/feed");
update();
}

async function play(){
await fetch("http://localhost:8080/play");
update();
}

async function sleep(){
await fetch("http://localhost:8080/sleep");
update();
}

const petDisplay = document.querySelector(".pet");

if(data.hunger > 70){
    petDisplay.innerText = "😫";
}
else if(data.energy < 30){
    petDisplay.innerText = "😴";
}
else if(data.happiness > 80){
    petDisplay.innerText = "😄";
}
else{
    petDisplay.innerText = "😺";
}