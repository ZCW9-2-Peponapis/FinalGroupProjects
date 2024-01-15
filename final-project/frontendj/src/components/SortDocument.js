import React, { useState } from "react";
import Doc from "./Doc";  //the Doc component is imported


const Library = ({ documents }) => {
  const [sortedDocuments, setSortedDocuments] = useState(documents);

  const sortByDate = () => {
    const sortedByDate = [...sortedDocuments].sort((a, b) => {
      return new Date(b.modificationDate) - new Date(a.modificationDate);
    });
    setSortedDocuments(sortedByDate);
  };

  const sortByTitle = () => {
    const sortedByTitle = [...sortedDocuments].sort((a, b) => {
      return a.title.localeCompare(b.title);
    });
    setSortedDocuments(sortedByTitle);
  };

  return (
    <div>
      <button onClick={sortByDate}>Sort by Date
      </button>
      <button onClick={sortByTitle}>Sort by Title
      </button>

      {/* {sortedDocuments.map((doc) => (
        <Doc key={doc.id} docDetails={doc} />
      ))} */
      }
    </div>
  );
};

export default Library;
