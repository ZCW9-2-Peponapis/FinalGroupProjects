import React, { useState } from 'react';
import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css'; // Import the styles

const TextEditor = () => {
    const [content, setContent] = useState('');

    const handleChange = (value) => {
        setContent(value);
    };

    const handleSave = () => {
        // You should implement the logic here to send the content to your server and save it to the database
        // For simplicity, let's assume you have an API endpoint '/saveContent' on your server

        fetch('http://your-server-api/saveContent', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ content }),
        })
            .then((response) => response.json())
            .then((data) => {
                console.log('Content saved successfully:', data);
                // You can handle success or display a notification to the user
            })
            .catch((error) => {
                console.error('Error saving content:', error);
                // Handle the error or display an error message to the user
            });
    };

    return (
        <div>
            <h1>Text Editor</h1>
            <ReactQuill value={content} onChange={handleChange} style={{height:'900px', width:'1000px'}}/>
            <div>
                <p>Content:</p>
                <div dangerouslySetInnerHTML={{ __html: content }} />
            </div>
            <button onClick={handleSave}>Save</button>
        </div>
    );
};

export default TextEditor;
