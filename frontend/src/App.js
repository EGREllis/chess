import { useState } from 'react';
import logo from './logo.svg';
import './App.css';
import LoginForm from './LoginForm.js';

function App() {
  const [user, setUser] = useState(null);

  function handleSuccessLogin(usernameValue) {
    var user = {username: usernameValue};
    setUser(user);
    alert("User: "+user);
  }

  const isLoggedIn = user === null;

  const loggedOut = (
    <LoginForm onLogin={handleSuccessLogin} />
  );

  const loggedIn = (
    <p>Welcome {user === null ? "" : user.username}</p>
  );

  return (
    <div className="App">
      {isLoggedIn ? loggedOut : loggedIn}
    </div>
  );
}

export default App;
