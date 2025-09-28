import { useState } from 'react';
import logo from './logo.svg';
import './App.css';
import LoginForm from './LoginForm.js';
import Lobby from './lobby/Lobby.js';

function App() {
  const [user, setUser] = useState(null);

  function handleSuccessLogin(usernameValue) {
    var user = {username: usernameValue};
    setUser(user);
    console.log("App user: "+JSON.stringify(user));
  }

  const isLoggedIn = user === null;

  const loggedOut = (
    <LoginForm onLogin={handleSuccessLogin} />
  );

  const loggedIn = (
    <div>
        <p>Welcome {user === null ? "" : user.username}</p>
        <Lobby />
    </div>
  );

  return (
    <div className="App">
      {isLoggedIn ? loggedOut : loggedIn}
    </div>
  );
}

export default App;
