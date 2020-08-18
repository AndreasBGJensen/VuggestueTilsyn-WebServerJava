import React from 'react'
import PostData from '../data/data.json'


var json =  {
    "payload": [
        {
            "id": 1,
            "name": "Atta",
            "brands": [
                {
                    "id": 118,
                    "name": "Wheatola",
                    "subProducts": [
                        {
                            "id": 858,
                            "name": "Chakki Aata",
                            "minPrice": 52,
                            "maxPrice": 56
                        },
                        {
                            "id": 2,
                            "name": "Chakki Atta",
                            "minPrice": 222,
                            "maxPrice": 236
                        }
                    ]
                }
            ]
        },
        {
            "id": 16,
            "name": "Rice (Branded)",
            "brands": [
                {
                    "id": 25,
                    "name": "CookStar",
                    "subProducts": [
                        {
                            "id": 1163,
                            "name": "Best Basmati",
                            "creditDays": 0,
                            "minPrice": 5600,
                            "maxPrice": 5600
                        },
                        {
                            "id": 863,
                            "name": "Extra Long Grain Basmati",
                            "creditDays": 0,
                            "minPrice": 7800,
                            "maxPrice": 7800
                        }
                    ]
                }
            ]
        }
    ]
};

class PostList extends React.Component {





    render() {
        return (
            <div>
                {
                    PostData.payload.map(j =>
                        <div>
                            {j.name}
                            {j.periodiskTilsyn.map(b =>
                                <div>
                                    {b.foerste.map(s =>
                                        <div>
                                            {s.Sprogindsatsen.map(k =>
                                                <div>
                                                    {k.indsats}
                                                </div>)
                                            }


                                        </div>



                                    )
                                    }
                                </div>
                            )}
                        </div>
                    )
                }
            </div>
        );
    }




}

export default PostList;