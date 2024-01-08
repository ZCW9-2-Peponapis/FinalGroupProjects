import {FrontPage} from "../pages/FrontPage";
import {DetailedPage} from "../pages/DetailedPage";
import {NotFound} from "../pages/NotFound";
import { BrowserRouter, Routes, Route} from 'react-router-dom';
export const  RoutePath =  () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path ="/">
                    <FrontPage/>
                </Route>
                <Route path='/notes'>
                    <DetailedPage/>
                </Route>
                <Route path='/error'>
                    <NotFound/>
                </Route>
            </Routes>
        </BrowserRouter>
    )




}