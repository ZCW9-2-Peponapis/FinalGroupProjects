import React, { useState, useEffect } from 'react';
import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css'; // Import the styles

const TextEditor = () => {
    const [content, setContent] = useState('');
    const [document, setDocument] = useState('');

    // fetching document from backend
    useEffect(() => {
        fetch('http://localhost:8080/document/view/253', {
            method: 'GET',
        }).then((res) => {
            return res.json();
        }).then((data) => {
            setContent(data.body);
            setDocument(data);
        });
    }, []);

    const handleChange = (value) => {
        setContent(value);
    };

    // resources: maybe will need this later when saving updates
    // https://jasonwatmore.com/post/2020/02/01/react-fetch-http-post-request-examples
    const handleSave = () => {
        // Your save logic here
    };

    // Define a custom toolbar
    const modules = {
        toolbar: [
            [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
            ['bold', 'italic', 'underline', 'strike'],
            [{ 'list': 'ordered' }, { 'list': 'bullet' }],
            ['link', 'image', 'video'],
            ['clean'],
        ],
    };

    // Define the formats
    const formats = [
        'header',
        'bold',
        'italic',
        'underline',
        'strike',
        'list',
        'bullet',
        'link',
        'image',
        'video',
    ];

    // Set default text color to black
    const styles = {
        color: 'black',
    };

    return (
        <div>
            <h1>Text Editor</h1>
            <h2>{document.title}</h2>
            <ReactQuill
                value={content}
                onChange={handleChange}
                modules={modules}
                formats={formats}
                style={{ height: '900px', width: '1000px', ...styles }}
            />
            <div>
                <p>Content:</p>
                <div dangerouslySetInnerHTML={{ __html: content }} />
            </div>
            <button onClick={handleSave}>Save</button>
            <button onClick={() => setReadOnly(!readOnly)}>
                {readOnly ? 'Enable Editing' : 'Disable Editing'}
            </button>
        </div>
    );
};

export default TextEditor;
