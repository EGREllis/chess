import React from 'react';

function LoginForm({onLogin}) {
    function onSubmit(e) {
        e.preventDefault();
        var ele = document.getElementById("username");

        async function registerPlayer(playerNameValue) {
            var player = {playerName: ele.value};

            const requestOptions = {
              method: 'POST',
              headers: { 'Content-Type': 'application/json' },
              credentials: "include",
              body: JSON.stringify(player),
            };

            console.log("Sending:\n"+JSON.stringify(requestOptions));

            const response = await fetch("http://localhost/api/players", requestOptions);
            console.log("Awaited response: "+response);
            const json = await response.json();
            console.log("Awaited json: "+JSON.stringify(json));
            onLogin(json.playerName)
            return json;
        }

        const playerJSON = registerPlayer(ele.value);
        console.log("Returning false");
        return false;
    }

    return (
        <div>
            <p>Please choose a username:</p>
            <form>
                <input type="text" placeholder="Username" id="username" />
                <button onClick={onSubmit}>Continue</button>
            </form>
        </div>
    );
}

export default LoginForm;