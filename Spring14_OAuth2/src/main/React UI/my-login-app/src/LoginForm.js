import React, { useState } from "react";
import axios from "axios";

const LoginForm = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8081/login", {
        username,
        password,
      });
      alert("Login successful!");
      console.log(response.data);
    } catch (error) {
      alert("Login failed! Please check your username and password.");
      console.error(error);
    }
  };

  const handleGoogleLogin = () => {
    window.location.href = "http://localhost:8081/oauth2/authorization/google";
  };

  const handleGitHubLogin = () => {
    window.location.href = "http://localhost:8081/oauth2/authorization/github";
  };

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Username:</label>
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Password:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit">Login</button>
      </form>
      <div>
        <h3>Or sign in with:</h3>
        <button onClick={handleGoogleLogin}>Sign in with Google</button>
        <button onClick={handleGitHubLogin}>Sign in with GitHub</button>
      </div>
    </div>
  );
};

export default LoginForm;
