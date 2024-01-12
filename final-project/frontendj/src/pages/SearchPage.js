import { useParams } from "react-router-dom";
import CreateDocumentIcon from "../components/CreateDocumentIcon";
import Doc from "../components/Doc";


function SearchPage() {
    const { search } = useParams(); // Pulling the data out of the URL
    const results = JSON.parse(decodeURI(search));
    console.log(search, results); // Fixed variable name
  
    return (
      <div className="App">
        <h1>Search Result</h1>
  
        {results && results.length > 0 ? (
          // Use parentheses to wrap the map function
          results.map((doc, index) => (
            <Doc key={index} {...doc} /> // Render the Doc component with spread operator
          ))
        ) : (
          <div className="App">
            <h1>No Result</h1>
          </div>
        )}
      </div>
    );
  }
  
  export default SearchPage;
  

