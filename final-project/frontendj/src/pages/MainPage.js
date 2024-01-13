
import CreateDocumentIcon from "../components/CreateDocumentIcon";
import { Outlet } from "react-router-dom";
import Library from "../components/Library";
<<<<<<< HEAD
import Searchbar from "../components/Searchbar";

=======
import SearchBar from "../components/Searchbar";
>>>>>>> 9a60d2fb50648bd23bea4c714d0a3e524e12dd28

function MainPage() {
    const path = `getAll`;

    return (
        <>
        <Outlet/>
        <div className="App">
            <header className="App-header">
                
                
                <h2>Welcome to Zip Docs</h2>

                
                      <SearchBar placeholder="Enter a Keyword"/>
                       

                <Library urlPath={path}/>


            </header>
        </div>
        </>
    );
}

export default MainPage;
