function getUserInfo() {
    const req = new XMLHttpRequest();

    req.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var data = this.responseText.split('#');

            var userInfoDiv = document.getElementById("userInfoDiv");


            for (var i = 0; i < data.length; i++) {
                var div = document.createElement("div");
                div.innerHTML = data[i];//data[2];
                userInfoDiv.appendChild(div);
            }
        }
    }

    req.open("GET", "userInfo", true);

    req.send();

}