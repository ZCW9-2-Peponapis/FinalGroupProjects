
import CreateDocumentIcon from "../components/CreateDocumentIcon";
import { Outlet } from "react-router-dom";
import Library from "../components/Library";

import SearchBar from "../components/Searchbar";



function MainPage() {
    const path = `getAll`;
    const page = "Main";

    return (
        <>
        <Outlet/>
        <div className="App">
            <header className="App-header">
                
                
                <h2>Welcome to ZipDocs</h2>
                       
                <SearchBar placeholder="Enter a Keyword"/>

                <Library urlPath={path} page={page}/>


            </header>
        </div>
        </>
    );
}

export default MainPage;
