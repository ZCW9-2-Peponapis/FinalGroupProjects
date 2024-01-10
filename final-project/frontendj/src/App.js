import googledoc from './googledoc.svg'
import './App.css';
import Login from "./components/Login";
import Library from './components/Library'

<<<<<<< HEAD
import RoutePath from "./components/RoutePath";
import UserComponent from "./components/UserComponent";
=======
import {RoutePath} from "./components/RoutePath";
import Register from "./components/Register";
import TextEditor from './components/TextEditor';
import LoginPage from './pages/LoginPage';
>>>>>>> 20e31f1 (playing with editor)



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
<<<<<<< HEAD
              <UserComponent/>
              <Library />
=======
              <TextEditor />
>>>>>>> 20e31f1 (playing with editor)
              <RoutePath/>
          </header>
      </div>


  );
}

export default App;
