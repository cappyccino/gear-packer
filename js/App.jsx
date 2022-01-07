import React from 'react'
import Header from "./components/header/Header"
import Pack from "./components/pack/Pack";

import './normalize.scss'
import './App.scss'

const App = () => {
    return (
        <>
            <Header/>
            <p>This is an integration test</p>
            <Pack/>
        </>
    )
}

export default App
