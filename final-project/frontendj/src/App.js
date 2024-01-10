import googledoc from './googledoc.svg'
import './App.css';
import Login from "./components/Login";

import RoutePath from "./components/RoutePath";
import UserComponent from "./components/UserComponent";



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
              <UserComponent/>
              <RoutePath />
          </header>
      </div>


  );
}

export default App;
