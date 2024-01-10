
const Document = () => {
    const [id, setId] = useState('');
    const [title, setTitle] = useState('');

    const getDocuments = async () => {
            try {
                const response = await fetch('http://localhost:8080/document/getAll', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                });

                if (response.ok) {
                    console.log('GET successful');
                    // Redirect or show success message
                } else {
                    console.error('GET failed');
                    // Handle login failure
                }
            } catch (error) {
                console.error('Error during fetching documents:', error.message);
            }
        };
}