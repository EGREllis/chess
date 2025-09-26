import React from 'react';

function LoginForm({onLogin}) {
    function onSubmit() {
        var ele = document.getElementById("username");
        alert("Login form says username is : "+ele.value);
        onLogin(ele.value);
    }

    return (
        <div>
            <p>Please choose a username:</p>
            <form onSubmit={onSubmit}>
                <input type="text" placeholder="Username" id="username" />
                <input type="submit" value="Proceed" />
            </form>
        </div>
    );
}

export default LoginForm;