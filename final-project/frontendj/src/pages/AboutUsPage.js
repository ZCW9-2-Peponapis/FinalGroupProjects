import React from 'react';
import './AboutUsPage.css';
import userPic from '../user.png';
import jia from '../profiles/hyunji.png'
import tam from '../profiles/tam.png'
import christy from '../profiles/christy.png'
import jiaqr from '../profiles/jiaQR.JPG'
import tamqr from '../profiles/tamqr.png'
import christyqr from '../profiles/christyQR.png'


function AboutUsPage (){


    return (
        <div className="about-section">
            <h1 style={{fontSize: '25px', marginTop: '-15px'}}>Our Team</h1>
            <h2 style={{marginBottom: '-30px'}}>Connect through our LinkedIn QR Codes</h2>

            <div className="row">
                <div className="column">
                    <div className="card">
                        <img src={tam} alt="Tam" style={{width: '100%'}}/>
                        <div className="container">
                            <h2>Tam Maria Doan</h2>
                            <img src={tamqr} alt="TamQR" style={{width: '80%'}}/>
                        </div>
                    </div>
                </div>

                <div className="column">
                    <div className="card">
                        <img src={christy} alt="Christy" style={{width: '100%'}}/>
                        <div className="container">
                            <h2>Christianne (Christy) Edgard</h2>
                            <img src={christyqr} alt="christyqr" style={{width: '80%'}}/>

                        </div>
                    </div>
                </div>

                <div className="column">
                    <div className="card">
                        <img src={jia} alt="Jia" style={{width: '100%'}}/>
                        <div className="container">
                            <h2>Hyunji (Jia) Lee</h2>
                            <img src={jiaqr} alt="JiaQR" style={{width: '80%'}}/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default AboutUsPage;
