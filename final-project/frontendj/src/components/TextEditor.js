import React, { useState } from 'react';
import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css'; // Import the styles

const TextEditor = () => {
    const [content, setContent] = useState('');

    const handleChange = (value) => {
        setContent(value);
    };

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
        </div>
    );
};

export default TextEditor;
