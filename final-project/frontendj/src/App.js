import googledoc from './googledoc.svg'
import './App.css';
import Login from "./components/Login";
import Library from './components/Library'

import RoutePath from "./components/RoutePath";
import UserComponent from "./components/UserComponent";
import Register from "./components/Register";
import TextEditor from './components/TextEditor';
import LoginPage from './pages/LoginPage';
import CreateDoc from './components/CreateDocumentIcon';
import CreateDocumentIcon from "./components/CreateDocumentIcon";



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
              <RoutePath/>
          </header>
      </div>


  );
}

export default App;
