
import CreateDocumentIcon from "../components/CreateDocumentIcon";
import { Outlet } from "react-router-dom";
import Library from "../components/Library";
import Searchbar from "../components/Searchbar";


function MainPage() {
    const path = `getAll`;

    return (
        <>
        <Outlet/>
        <div className="App">
            <header className="App-header">
                Welcome to Zip Docs

                <div className="App">
                    <Searchbar placeholder="Enter a Keyword"/>
                </div>

                <Library urlPath={path}/>


            </header>
        </div>
        </>
    );
}

export default MainPage;
