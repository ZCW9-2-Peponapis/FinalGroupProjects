import googledoc from './googledoc.svg'
import './App.css';
import HelloWorld from "./components/HelloWorld";
import Login from "./components/Login";
import Register from "./components/Register";
import {FrontPage} from "./pages/FrontPage";
import TextEditor from "./components/TextEditor";
import LoginButton from "./components/LoginButton";
import RegisterButton from "./components/RegisterButton";

function App() {
  return (
      <div className="App">
          <header className="App-header">
              <img src={googledoc} className="App-logo" alt="logo"/>
              <a
                  className="App-link"
                  href="https://github.com/ZCW9-2-Peponapis/FinalGroupProjects"
                  target="_blank"
                  rel="noopener noreferrer"
              >
                  Zip Docs
              </a>
              <TextEditor/>

              <LoginButton/>
              <RegisterButton/>


          </header>
      </div>

  );
}

export default App;
