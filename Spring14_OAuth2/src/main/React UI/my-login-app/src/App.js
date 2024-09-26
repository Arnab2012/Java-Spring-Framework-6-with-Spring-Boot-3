// Import React and the CSS file
import React from 'react';
import './App.css';

// Import your LoginForm component
import LoginForm from './LoginForm'; 

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Login Page</h1>
        {/* Render the LoginForm component here */}
        <LoginForm />
      </header>
    </div>
  );
}

export default App;
