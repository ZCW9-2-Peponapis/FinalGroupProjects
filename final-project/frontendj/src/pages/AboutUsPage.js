import React from 'react';
import './AboutUsPage.css';
import userPic from '../user.png';

function AboutUsPage (){


    return (
        <div className="about-section">
            <h1>About Us Page</h1>
            <p>Thank you for your time. Hope you enjoy ZipDocs!</p>
            <p>We would love to answer any questions.</p>

            <h2 style={{ textAlign: 'center' }}>Our Team</h2>

            <div className="row">
                <div className="column">
                    <div className="card">
                        <img src={userPic} alt="Tam" style={{ width: '100%' }} />
                        <div className="container">
                            <h2>Tam Maria Doan</h2>
                            <p className="title">Software Developer</p>
                            <p>Description.</p>
                            <p>email@example.com</p>
                            <p><button className="button">Contact</button></p>
                        </div>
                    </div>
                </div>

                <div className="column">
                    <div className="card">
                        <img src={userPic} alt="Christy" style={{ width: '100%' }} />
                        <div className="container">
                            <h2>Christianne Edgard</h2>
                            <p className="title">Software Developer</p>
                            <p>Description.</p>
                            <p>Edgardchristianne@gmail.com</p>
                            <p><button className="button">Contact</button></p>
                        </div>
                    </div>
                </div>

                <div className="column">
                    <div className="card">
                        <img src={userPic} alt="Jia" style={{ width: '100%' }} />
                        <div className="container">
                            <h2>Hyunji Lee</h2>
                            <p className="title">Software Developer</p>
                            <p>B.A in Psychology</p>
                            <p>hyjialee@gmail.com</p>
                            <p><button className="button">Contact</button></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default AboutUsPage;
